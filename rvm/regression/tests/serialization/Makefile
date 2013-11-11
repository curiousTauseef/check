#
# (C) Copyright IBM Corp. 2001
#
#
# $Id: Makefile,v 1.4 2003/08/13 20:08:47 dgrove-oss Exp $
#
# @author Julian Dolby
#
include $(RVM_BUILD)/Make.rules.target

BENCH_HOME=$(JAL_ROOT)/rvm/src/examples/serialization
BENCH_SOURCE_PATH=$(BENCH_HOME)
HEAPSIZE=50
LARGEHEAPSIZE=30

include $(JAL_ROOT)/rvm/regression/Make.rules

TESTS=TestWrite TestRead

sanity: $(TESTS)
	$(MAKE) do-sanity-finish

$(TESTS): %:
	$(MAKE) START_NAME=$@ START_ARGS=out.TestWrite.$(BOOTNAME).jdk do-sanity-compare

