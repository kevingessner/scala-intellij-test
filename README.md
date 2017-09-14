# scala-intellij-test

A test case for https://github.com/bazelbuild/rules_scala/issues/277

Tested with the following on OS X:

- bazel version: 0.5.4-homebrew (I'm on OS X)
- rules_scala: 23d94ae
- intellij: IntelliJ IDEA 2017.2.4
- bazel for intellij plugin: 2017.08.29.0.2

This project uses Twitter's `util-function` library to show how IntelliJ fails to analyse it correctly; I chose this
library because it doesn't have any dependencies.

## Build

```
bazel run :example_deploy -- some args
```

Prints the arguments.

## Import to IntelliJ

Import the project into IntelliJ using the provided `.bazelproject`.  Run `Sync project with build files` to see an
error in the bazel console like:

```
ERROR: /Users/kgessner/development/scala-intellij-test/BUILD:3:1: in @intellij_aspect//:intellij_info.bzl%intellij_info_aspect aspect on scala_library rule //:example: 
Traceback (most recent call last):
    File "/Users/kgessner/development/scala-intellij-test/BUILD", line 3
        @intellij_aspect//:intellij_info.bzl%intellij_info_aspect(...)
    File "/private/var/tmp/_bazel_kgessner/a5426e3b16c13a948aee4cb67dbbe4ff/external/intellij_aspect/intellij_info.bzl", line 18, in _aspect_impl
        intellij_info_aspect_impl(target, ctx, semantics)
    File "/private/var/tmp/_bazel_kgessner/a5426e3b16c13a948aee4cb67dbbe4ff/external/intellij_aspect/intellij_info_impl.bzl", line 691, in intellij_info_aspect_impl
        collect_java_info(target, ctx, semantics, ide_info, <2 more arguments>)
    File "/private/var/tmp/_bazel_kgessner/a5426e3b16c13a948aee4cb67dbbe4ff/external/intellij_aspect/intellij_info_impl.bzl", line 386, in collect_java_info
        library_artifact(output)
    File "/private/var/tmp/_bazel_kgessner/a5426e3b16c13a948aee4cb67dbbe4ff/external/intellij_aspect/intellij_info_impl.bzl", line 130, in library_artifact
        java_output.class_jar
object of type 'File' has no field 'class_jar'.
```

Open `Example.scala` in the editor to see that its dependencies are not correctly analyzed.
