#!/bin/bash


TIMESTAMP=`cat /var/log/DOCKER_BUILD_TIME`


cat << EOF

williamyeh/cseg - Chinese segmentation tools for plaintext UTF-8 corpus.
Image built at: $TIMESTAMP

Env
===

- Exported volumes:

    * [IN]     /data/dict - for dictionary files.
    * [IN,OUT] /data/file - for corpus files.


Usage
=====

## segmentation for file

  Cmd:  cseg  <input-file>  <output-file>

  Examples:

    # simple segmentation;
    # use current directory "\$(pwd)" for file input/output.
    $ docker run --rm          \\
        -v \$(pwd):/data/file   \\
        williamyeh/cseg  cseg  input.txt  output.txt


    # segmentation, using customized dictionaries;
    # assume that dictionaries are located in "/MY_DICTIONARY_DIR" of host OS.
    $ docker run --rm          \\
        -v /MY_DICTIONARY_DIR:/data/dict   \\
        -v \$(pwd):/data/file               \\
        williamyeh/cseg  cseg  input.txt  output.txt



More Info
=========

For more info, see official ansj_seg site:

    https://github.com/ansjsun/ansj_seg


EOF
