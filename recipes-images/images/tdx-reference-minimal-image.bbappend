TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server"

SYSTEMD_DEFAULT_TARGET = "multi-user.target"

IMAGE_LINGUAS = "en-us"

CONMANPKGS = " "

IMAGE_INSTALL:append = "lighttpd picocom htop vim"

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
