TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server"

SYSTEMD_DEFAULT_TARGET = "multi-user.target"

IMAGE_LINGUAS = "en-us"

NETWORK_MANAGER = " \
                   networkmanager \
                   networkmanager-nmtui \
                   "


IMAGE_INSTALL:append = " \
                        lighttpd \
                        lighttpd-module-cgi \
                        picocom \
                        htop \
                        nano \
                        net-tools \
                        vim \
                        sudo \
                        "

#
# Desenvolvimento
#
IMAGE_INSTALL:append = " \
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
