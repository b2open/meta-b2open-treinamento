# Commando generate password: printf "%q" $(mkpasswd -m sha256crypt tester01)

# senha: toor
PASSWD_ROOT="\$5\$hoAlicIPUGqfOcWp\$TNEei7uu5fxx3vLGlypOVbtSgQmZ4jGZj4sq3MPcEcC"
# senha: b2open
PASSWD_USER="\$5\$PJsMh2rPmRp68Ty8\$t6sFiqgW9FtwiA6h/Ab8c.wus90IZhyNxgAdGszRtZ5"

EXTRA_USERS_PARAMS = "\
                      useradd b2open; \
                      usermod -p '${PASSWD_USER}' b2open; \
                      usermod -a -G sudo,users,plugdev b2open; \
                      usermod -p '${PASSWD_ROOT}' root; \
                      "

inherit extrausers
