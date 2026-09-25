FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
                  file://imx8dx-colibri-eval-v3.dts \
                  file://imx8qxp-colibri-eval-v3.dts \
                  "

do_configure:prepend() {
    cp ${WORKDIR}/imx8dx-colibri-eval-v3.dts  ${S}/arch/arm64/boot/dts/freescale/
    cp ${WORKDIR}/imx8qxp-colibri-eval-v3.dts ${S}/arch/arm64/boot/dts/freescale/
}

# Reduz o tempo de download e o tamanho do repositório,
# buscando apenas os 10 commits mais recentes
BB_GIT_SHALLOW = "1"
BB_GIT_SHALLOW_DEPTH = "10"
