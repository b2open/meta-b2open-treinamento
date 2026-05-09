inherit core-image

SUMMARY = "B2Open Systems Embedded Linux Reference Console Image"
DESCRIPTION = "Minimal image without graphical interface"

LICENSE = "MIT"

# Prefix to the resulting deployable tarball name
export IMAGE_BASENAME = "B2Open-Console-Image"

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
                        sudo \
                        "

#
# Desenvolvimento
#
IMAGE_INSTALL:append = "\
                       bc \
                       bmon \
                       cpufrequtils \
                       cmake \
                       dtc \
                       evtest \
                       i2c-tools \
                       iperf3 \
                       fbida \
                       gdbserver \
                       libgpiod \
                       libgpiod-dev \
                       libgpiod-python \
                       libgpiod-tools \
                       libudev \
                       libusb1 \
                       libusb1-dev \
                       lmsensors \
                       lsof \
                       mmc-utils \
                       packagegroup-core-buildessential \
                       powertop \
                       python3-smbus2 \
                       spitools \
                       systemd-dev \
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

include b2-users.inc
