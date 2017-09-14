maven_jar(
    name = "com_twitter_util_function",
    artifact = "com.twitter:util-function_2.11:7.0.0",
    sha1 = "117433521f29155000fea89ef2debb4da7f90383",
)

rules_scala_version="23d94aec640ebfdcf862d9dcc20ab14c4eb448c9" # update this as needed

http_archive(
    name = "io_bazel_rules_scala",
    url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip"%rules_scala_version,
    type = "zip",
    strip_prefix= "rules_scala-%s" % rules_scala_version
)

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")
scala_repositories()
