#
# (C) Copyright IBM Corp. 2001
#
#
# $Id: Makefile,v 1.7 2003/08/13 20:08:46 dgrove-oss Exp $
#
# @author Julian Dolby
#
include $(RVM_BUILD)/Make.rules.target

BENCH_HOME=$(JAL_ROOT)/rvm/src/examples/reflect
BENCH_SOURCE_PATH=$(BENCH_HOME)
HEAPSIZE=150
LARGEHEAPSIZE=30

include $(JAL_ROOT)/rvm/regression/Make.rules

TESTS=tArray tClass tField tInstance

sanity: $(TESTS)
	$(MAKE) do-sanity-finish

$(TESTS): %:
	$(MAKE) START_NAME=$@ EXPECTED=$@.expected sanity-diff
