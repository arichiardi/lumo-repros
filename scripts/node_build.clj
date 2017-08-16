(require 'cljs.repl)
(require 'cljs.build.api)
(require 'cljs.repl.node)

(cljs.build.api/build "src" {:output-to     "out/logpoc/logpoc.js"
                             ;; :output-dir    "out/logpoc"
                             :target        :nodejs
                             :language-in   :ecmascript5
                             :optimizations :none
                             :node-modules true
                             :main "logpoc.core"})
