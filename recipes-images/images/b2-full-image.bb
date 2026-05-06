inherit core-image

SUMMARY = "B2Open Systems Embedded Linux Reference Console Image with Qt5"
DESCRIPTION = "Minimal image with Framework Qt5"

LICENSE = "MIT"

# Prefix to the resulting deployable tarball name
export IMAGE_BASENAME = "B2Open-Full-Image"

TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server"

SYSTEMD_DEFAULT_TARGET = "multi-user.target"

IMAGE_LINGUAS = "en-us"

CORE_IMAGE_BASE_INSTALL:append:mx8 = " kernel-module-imx-gpu-viv"

IMAGE_INSTALL:append = " \
    packagegroup-basic \
    packagegroup-boot \
    packagegroup-base-tdx-cli \
    packagegroup-machine-tdx-cli \
    packagegroup-wifi-tdx-cli \
    packagegroup-wifi-fw-tdx-cli \
    packagegroup-tdx-cli \
    \
    bash \
    coreutils \
    kernel-modules \
    less \
    makedevs \
    mime-support \
    udev-extraconf \
    util-linux \
    u-boot-fw-utils \
"

CONMANPKGS = " "
IMAGE_INSTALL:append = "\
                        networkmanager \
                        networkmanager-nmtui \
                        sudo \
                        "

#
# Desenvolvimento
#
IMAGE_INSTALL:append = "\
                        binutils gcc \
                        cpufrequtils \
                        cmake \
                        dtc \
                        evtest \
                        i2c-tools \
                        fbida \
                        gdbserver \
                        libgpiod libgpiod-dev libgpiod-python libgpiod-tools \
                        libudev systemd-dev \			
                        libusb1 libusb1-dev \
                        make \
                        python3-smbus2 \
                        spitools \
                        rsync \
                        ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'timestamp-service systemd-analyze', '', d)} \
                        "

#
# Ferramentas
#
IMAGE_INSTALL:append = "\
                       bmode-usb \
                       can-utils \
                       coreutils \
                       fbida \
                       htop \
                       minicom \
                       nano \
                       net-tools \
                       netcat \
                       picocom \
                       powertop \
                       uhubctl \
                       util-linux \
                       util-linux-libuuid \
                       vim \
                       "

#
# Qt
#
IMAGE_INSTALL:append = "\
                       qt3d \
                       qtbase \
                       qtcharts \
                       qtdeclarative \
                       qtgraphicaleffects \
                       qtimageformats \
                       qtlocation \
                       qtmultimedia \
                       qtquickcontrols2 \
                       qtquickcontrols \
                       qtserialbus \
                       qtserialport \
                       qtsvg \
                       qtsystems \
                       qttools \
                       qttranslations \
                       qtvirtualkeyboard \
                       qtxmlpatterns \
                       \
                       cinematicexperience \
                       qt5everywheredemo \
                       gstreamer1.0 \
                       gstreamer1.0-plugins-base \
                       gstreamer1.0-plugins-good \
                       gstreamer1.0-plugins-bad \
                       imx-gst1.0-plugin \
                       imx-gst1.0-plugin-gplay \
                       imx-gst1.0-plugin-grecorder \
                       packagegroup-fsl-gstreamer1.0-full \
                       "

include b2-users.inc
