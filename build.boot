(def project 'speed-of-light)
(def version "0.1.0-SNAPSHOT")

(def dependencies '[[org.clojure/clojure "1.9.0-alpha15"]
                    [org.clojure/spec.alpha "0.1.123"]
                    [org.clojure/test.check "0.10.0-alpha2"]])

(def js-deps [])

(def exclusions '[org.clojure/core.async])

(set-env! :source-paths #{"src"})

(task-options!
 pom {:project     project
      :version     version
      :description "FIXME: write description"
      :url         "https://github.elasticpath.net/arichiardi/dynamodb-speed-of-light"
      :scm         {:url "scm:git:git@github.elasticpath.net:arichiardi/dynamodb-speed-of-light.git"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}}
 with-cp {:safe true
          :file "cp"})

(require '[boot.util :as util])

(deftask dump-cp
  "Dump the classpath require by the self-hosted cljs app"
  []
  (util/info "Dumping the classpath...\n")
  (comp
   (if (seq dependencies)
     (with-cp
       :write true
       :exclusions exclusions
       :dependencies dependencies)
     identity)
   (if (seq js-deps)
     (with-pass-thru fs
       (apply util/dosh (concat ["yarn" "add"] js-deps)))
     identity)))

(deftask dev
  "Launches the interactive environment"
  [p port PORT int "Set the repl port"]
  (comp
   (dump-cp)
   (with-pass-thru fs
     (util/dosh "lumo" "-c" (slurp "cp") "-n" (str (or port 5044))))))
