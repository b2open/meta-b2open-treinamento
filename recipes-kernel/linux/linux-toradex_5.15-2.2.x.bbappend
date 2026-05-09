FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}-5.15:"

SRC_URI:append = "\
                  file://imx8dx-colibri-eval-v3.dts \
                  file://imx8qxp-colibri-eval-v3.dts \
                  "

do_configure:prepend() {
    cp ${WORKDIR}/imx8dx-colibri-eval-v3.dts  ${S}/arch/arm64/boot/dts/freescale/
    cp ${WORKDIR}/imx8qxp-colibri-eval-v3.dts ${S}/arch/arm64/boot/dts/freescale/
}
