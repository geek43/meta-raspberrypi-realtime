require recipes-kernel/linux/linux-raspberrypi_6.6.bb

SECTION = "Xenomai4 kernel"
SUMMARY = "Xenomai4 kernel for Raspberrypi"
DESCRIPTION = "Recipe to build xenomai Linux kernel"

SRC_URI:append = "file://xenomai4-v6.6.41-evl2.patch \
		file://xenomai4.cfg \
		"
S = "${WORKDIR}/git"

LINUX_VERSION_EXTENSION:append = "-xeno4"
