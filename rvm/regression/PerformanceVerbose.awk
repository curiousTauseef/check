#
# (C) Copyright IBM Corp. 2001
#
# $Id: PerformanceVerbose.awk,v 1.2 2001/11/02 18:08:18 pfs-oss Exp $
#
# @author Julian Dolby

/^RESULT:/ { 
    if ("x$4" != "x") {
	currentImage = $2.$4; currentBench = $3; 
        print " ";
    } else {
	currentImage = $2; currentBench = $3; 
        print " ";
    }
}

/./ { 
  if (targetBench == currentBench) {
     print;
  }
}
