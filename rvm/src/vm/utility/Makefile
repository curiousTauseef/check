#
# (C) Copyright IBM Corp. 2003
#
#$Id: Makefile,v 1.4 2004/03/27 14:53:46 augart-oss Exp $
# @author Dave Grove

include			$(RVM_BUILD)/Make.rules.host

MakeTemplates:		$(GEN_FILES_DIR)/VM_Options.java

BOOLEAN_DAT_FILES = BooleanOptions.dat
VALUE_DAT_FILES = ValueOptions.dat

$(GEN_FILES_DIR)/VM_Options.java: VM_Options.template \
				$(BOOLEAN_DAT_FILES) \
				$(VALUE_DAT_FILES)
	$(TemplateExpander_HOST_VM_RT) -classpath $(SCRATCH_DIR) \
	GenerateFromTemplate VM_Options.template \
	$(GEN_FILES_DIR)/VM_Options.java \
        BOOLEAN_DAT_FILES="$(BOOLEAN_DAT_FILES)" \
	VALUE_DAT_FILES="$(VALUE_DAT_FILES)" 
