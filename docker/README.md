williamyeh/cseg
===============


## Summary

Repository name in Docker Hub: **[williamyeh/cseg](https://registry.hub.docker.com/u/williamyeh/cseg/)**

This repository contains **Dockerfile** of [cseg](https://github.com/William-Yeh/cseg) for [Docker](http://www.docker.com/)'s [automated build](https://registry.hub.docker.com/u/williamyeh/cseg/) published to the public [Docker Hub](https://hub.docker.com/).





## Configuration

This docker image contains the following software stack:

- OS: Debian jessie.

- Java: Oracle JDK 1.8.0

- [ansj_seg](https://github.com/ansjsun/ansj_seg): fetched from its own Maven repository.

- [cseg](https://github.com/William-Yeh/cseg)



### Dependencies

- [williamyeh/docker-java8](https://github.com/William-Yeh/docker-java8)


### History

- 0.1 - Initial release.




## Usage


#### Show usage

```
$ docker run --rm williamyeh/cseg
```



## Credit

Thanks for the great [ansj_seg](https://github.com/ansjsun/ansj_seg) project.


## License

[Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0), same as the [ansj_seg](https://github.com/ansjsun/ansj_seg) project.
