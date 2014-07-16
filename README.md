Chinese segmentation tool for plaintext UTF-8 corpus
====================================================

A simple tool for Chinese segmentation.



## Build

```
$ gradle download
$ gradle build

$ ls -al build/libs
```

You should see a `cseg-all.jar` file in the `build/libs` directory now.



## Install

Assume that you'd like to install the tool into `/opt/cseg` directory:


1. Make sure the directory exist:

   ```
   $ mkdir /opt/cseg
   ```

2. Copy `build/downloaded-resources/*` files:

   ```
   $ cp -r build/downloaded-resources/*  /opt/cseg
   ```

3. Copy `build/libs/*` files:

   ```
   $ cp -r build/libs/*  /opt/cseg
   ```

4. Edit the `library.properties` file:

   ```
   $ sed -i -e 's/=library/=\/opt\/cseg\/library/' \
         /opt/cseg/library.properties
   ```




## Usage

Assume that it is installed on the `/opt/cseg` directory:


```
$ java -cp "/opt/cseg:/opt/cseg/cseg-all.jar" CSeg \
    <input file>  <output file>
```

You could create a wrapper script or batch file to simplify the command line.



## TODO

- Docker version.

- Convenient script wrapper.

- POS tagger.



## Credit

Thanks the great [ansj_seg](https://github.com/ansjsun/ansj_seg) project.


## License

Apache License 2.0, same as the [ansj_seg](https://github.com/ansjsun/ansj_seg) project.
