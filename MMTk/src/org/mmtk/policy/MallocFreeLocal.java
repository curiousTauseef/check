/*
 * (C) Copyright Department of Computer Science,
 * Australian National University. 2003
 */
package org.mmtk.policy;

import org.mmtk.plan.MallocFree;
import org.mmtk.utility.alloc.BlockAllocator;
import org.mmtk.utility.alloc.SegregatedFreeList;
import org.mmtk.utility.Log;
import org.mmtk.utility.Constants;

import org.vmmagic.unboxed.*;
import org.vmmagic.pragma.*;

/** JREG Extension */
public final class MallocFreeLocal extends SegregatedFreeList implements
		Constants, Uninterruptible {

	static {
		cellSize = new int[SIZE_CLASSES];
		blockSizeClass = new byte[SIZE_CLASSES];
		cellsInBlock = new int[SIZE_CLASSES];
		blockHeaderSize = new int[SIZE_CLASSES];

		for (int sc = 0; sc < SIZE_CLASSES; sc++) {
			cellSize[sc] = getBaseCellSize(sc);
			for (byte blk = 0; blk < BlockAllocator.BLOCK_SIZE_CLASSES; blk++) {
				int usableBytes = BlockAllocator.blockSize(blk);
				int cells = usableBytes / cellSize[sc];
				blockSizeClass[sc] = blk;
				cellsInBlock[sc] = cells;
				/* cells must start at multiple of MIN_ALIGNMENT because
				 cellSize is also supposed to be multiple, this should do
				 the trick: */
				blockHeaderSize[sc] = BlockAllocator.blockSize(blk) - cells
						* cellSize[sc];
				if (((usableBytes < BYTES_IN_PAGE) && (cells * 2 > MAX_CELLS))
						|| ((usableBytes > (BYTES_IN_PAGE >> 1)) && (cells > MIN_CELLS)))
					break;
			}
		}
		
	}

	public MallocFreeLocal(Space space) {
		super(space);
	}

	protected final Address advanceToBlock(Address block, int sizeClass)
			throws InlinePragma {
		return getFreeList(block);
	}

	public final boolean preserveFreeList() throws InlinePragma {
		return true;
	}

	protected final boolean maintainInUse() throws InlinePragma {
		return true;
	}

	public final void prepare() throws InlinePragma {
		flushFreeLists();
	}

	public void release() throws InlinePragma {
		flushFreeLists();
		sweepBlocks();
		restoreFreeLists();
	}
}
