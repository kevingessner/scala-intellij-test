load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary")

scala_library(
    name = "example",
    visibility = [
        "//visibility:public",
    ],
    deps = [
        "@com_twitter_util_function//jar:file",
    ],
    srcs = ["Example.scala"],
)

scala_binary(
    name = "example_binary",
    main_class = "Example",
    deps = [":example"],
)
