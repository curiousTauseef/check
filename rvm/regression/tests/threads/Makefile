#
# (C) Copyright IBM Corp. 2001
#
#
# $Id: Makefile,v 1.9 2003/08/13 20:08:49 dgrove-oss Exp $
#
# @author Julian Dolby
#
include		$(RVM_BUILD)/Make.rules.target

BENCH_HOME=$(JAL_ROOT)/rvm/src/examples/threads
BENCH_SOURCE_PATH=$(BENCH_HOME)
HEAPSIZE=150
NON_DETERMINISTIC_OUTPUT_ORDER=YES

include		$(JAL_ROOT)/rvm/regression/Make.rules

TESTS=TestNotification TestDispatch TestTimedWait TestInterruptAndSpin TestInterruptedSleep TestInterruptedWait

$(TESTS): %:
	$(MAKE) START_NAME=$@ do-sanity-compare

sanity:		$(TESTS)
	$(MAKE) do-sanity-finish
