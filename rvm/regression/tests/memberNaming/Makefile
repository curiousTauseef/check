#
# (C) Copyright IBM Corp. 2001
#
#
# $Id: Makefile,v 1.3 2003/08/13 20:08:42 dgrove-oss Exp $
#
# @author Dave Grove
#
include $(RVM_BUILD)/Make.rules.target

BENCH_HOME=$(JAL_ROOT)/rvm/src/examples/memberNaming
BENCH_SOURCE_PATH=$(BENCH_HOME)
HEAPSIZE=150
LARGEHEAPSIZE=30

include $(JAL_ROOT)/rvm/regression/Make.rules

TESTS=ResolvedAccess

sanity: $(TESTS)
	$(MAKE) do-sanity-finish

$(TESTS): %:
	$(MAKE) START_NAME=$@ do-sanity-compare

