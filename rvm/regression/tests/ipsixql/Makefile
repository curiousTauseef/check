#
# (C) Copyright IBM Corp. 2003
#
# $Id: Makefile,v 1.4 2003/08/13 20:08:38 dgrove-oss Exp $
#
# @author Michael Hind
#

include		$(RVM_BUILD)/Make.rules.target

BENCH_NAME=ipsixql
include		$(JAL_ROOT)/rvm/regression/Local.rules

BENCH_CLASS_PATH=$(BENCH_HOME)
BENCH_SOURCE_PATH=$(BENCH_HOME)
HEAPSIZE = 50
START_NAME=IpsixqlHarness
EXPECTED=ipsixql.expected

ifeq ($(MODE),PERFORMANCE)
  START_ARGS=1 7
else
  START_ARGS=1 1
endif

include		$(JAL_ROOT)/rvm/regression/Make.rules

$(WORKING)/william.pdom:	$(WORKING)
	 cp -f $(BENCH_SOURCE_PATH)/william.pdom $(WORKING)/william.pdom

sanity: 	$(WORKING)/william.pdom sanity-check-rule

do-gather-performance:
	 @$(AWK) -f $(JAL_ROOT)/rvm/regression/tests/ipsixql/perf.awk $(OUT) >> $(PERF_LOG)

check:
	@$(FGREP) "Normal completion" $(OUT) > /dev/null

