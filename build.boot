(def project 'speed-of-light)
(def version "0.1.0-SNAPSHOT")

(def dependencies '[[org.clojure/clojure "1.9.0-alpha14"]
                    [cljsjs/aws-sdk-js "2.2.41-4"]])

(def js-deps ["aws-sdk"])

(def exclusions '[org.clojure/core.async])

(set-env! :source-paths #{"src"}
          :dependencies '[[arichiardi/boot-dynamodb "0.1.0-SNAPSHOT" :scope "test"]])

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

(require '[boot-dynamodb.core :refer [local-dynamodb]]
         '[boot.util :as util])

(deftask dump-cp
  "Dump the classpath require by the self-hosted cljs app"
  []
  (util/info "Dumping the classpath...\n")
  (comp
   (with-cp
     :write true
     :exclusions exclusions
     :dependencies dependencies)
   (with-pass-thru fs
     (apply util/dosh (concat ["yarn" "add"] js-deps)))))

(deftask dev
  "Launches the interactive environment"
  [p port PORT int "Set the repl port"]
  (comp
   (dump-cp)
   (with-pass-thru fs
     (util/dosh "lumo" "-c" (slurp "cp") "-n" (str (or port 5044))))))
