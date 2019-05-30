DESCRIPTION = "Input daemon for XenClient"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=321bf41f280cf805086dd5a720b37785"
DEPENDS = "xen libxcdbus udev openssl libevent libxcxenstore libdmbus libxenbackend xenfb2"

RDEPENDS_${PN} += "xenclient-keyboard-list libxcxenstore"

PV = "0+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRC_URI = "git://${OPENXT_GIT_MIRROR}/input.git;protocol=${OPENXT_GIT_PROTOCOL};branch=${OPENXT_BRANCH} \
	   file://input-daemon.initscript \
"

<<<<<<< HEAD
EXTRA_OECONF += "--with-idldir=${STAGING_IDLDIR}"
EXTRA_OECONF += "--with-rpcgen-templates=${STAGING_DATADIR_NATIVE}/xc-rpcgen-1.0/templates"

=======
>>>>>>> upstream/stable-8
CFLAGS_append += " -Wno-unused-parameter -Wno-deprecated-declarations "

S = "${WORKDIR}/git"

ASNEEDED = ""

LDFLAGS += "-lm -lcrypto"

inherit autotools xenclient update-rc.d pkgconfig xc-rpcgen-c


INITSCRIPT_NAME = "xenclient-input"
INITSCRIPT_PARAMS = "defaults 75"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/input-daemon.initscript ${D}${sysconfdir}/init.d/xenclient-input
}