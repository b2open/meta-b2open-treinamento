FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-6.6:"

# Fragments
SRC_URI:append = "\
                  file://sensors.cfg \
                  "

# Files
SRC_URI:append = "\
                  file://imx8qxp-colibri-eval-v3.dts \
                  file://imx8dx-colibri-eval-v3.dts \
                  "

# Patches
SRC_URI:append = " "

do_configure:prepend() {
    cp ${WORKDIR}/imx8dx-colibri-eval-v3.dts  ${S}/arch/arm64/boot/dts/freescale/
    cp ${WORKDIR}/imx8qxp-colibri-eval-v3.dts ${S}/arch/arm64/boot/dts/freescale/
}
