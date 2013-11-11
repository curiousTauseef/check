/*
 * (C) Copyright IBM Corp 2003
 */
//$Id: initBootRecord.C,v 1.1 2003/03/12 21:34:49 dgrove-oss Exp $

/*
 * Segregate the code to initialize the boot record, 
 * because the machine generated cruft in InterfaceDeclarations.h
 * causes gcc 3.2 to complain bitterly...
 * @author Dave Grove
 */

#define NEED_BOOT_RECORD_DECLARATIONS
#define NEED_BOOT_RECORD_INITIALIZATION
#include <AixLinkageLayout.h>
#include <InterfaceDeclarations.h>
