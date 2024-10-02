require recipes-core/images/core-image-base.bb

# Skip processing of this recipe if linux-raspberrypi-rt/xeno4 is not explicitly specified
# as the PREFERRED_PROVIDER for virtual/kernel. This avoids errors when trying
# to build multiple virtual/kernel providers.
python () {
    if d.getVar("PREFERRED_PROVIDER_virtual/kernel") == "linux-raspberrypi":
        raise bb.parse.SkipRecipe("Do not set PREFERRED_PROVIDER_virtual/kernel to linux-raspberrypi to enable it")
}

DESCRIPTION = "A small image just capable of allowing a device to boot plus a \
real-time test suite and tools appropriate for real-time use."

IMAGE_INSTALL:append = " rt-tests hwlatdetect gnuplot stress-ng htop"
IMAGE_INSTALL:append = " ${@bb.utils.contains('PREFERRED_PROVIDER_virtual/kernel', 'linux-raspberrypi-xeno4', 'xenomai4', '', d)}"

LICENSE = "MIT"
