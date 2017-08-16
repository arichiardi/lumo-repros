(require 'cljs.repl)
(require 'cljs.build.api)
(require 'cljs.repl.node)

(cljs.build.api/build "src" {:output-to     "out/logpoc/logpoc.js"
                             :language-in   :ecmascript5
                             :node-modules true
                             :repl-verbose true
                             :verbose true
                             :main 'logpoc.core})

(cljs.repl/repl (cljs.repl.node/repl-env)
  :watch "src"
  :output-dir "out")
