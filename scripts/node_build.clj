(require 'cljs.build.api)

(cljs.build.api/build "src"
                      {:main 'speed-of-light.core
                       :output-to "out-jvm/speed_of_light.js"
                       :optimizations :none
                       :source-map false
                       :target :nodejs
                       :verbose true})
