(ns menu
  (:require [compress]))

(defn display-file-list []
  (let [files (file-seq (clojure.java.io/file "."))
        file-names (map str files)]
    (println "File List:")
    (doseq [file file-names]
      (println "* " file))))
   

(defn display-file-contents []
  (print "Please enter a file name => ")
  (flush) ; Ensures the prompt is immediately displayed
   
  (let [file-name (read-line)]
    (try
      
      (let [content (slurp file-name)]
        (println)
        (println content))
      (catch java.io.FileNotFoundException _
        (println "Oops: specified file does not exist")))))



(defn compress-file []
  (print "Please enter a file name => ")
  (flush) ; Ensures the prompt is immediately displayed

  (let [file-name (read-line)]
    (try
      (let [compressed-text (compress/compress-file (slurp file-name))]
        (with-open [output-file (clojure.java.io/writer (str file-name ".ct"))]
          (.write output-file compressed-text)))
      (catch java.io.FileNotFoundException _ (println "Oops: specified file does not exist.")))))


(defn uncompress-file []
  (print "Please enter a file name => ")
  (flush) ; Ensures the prompt is immediately displayed

  (let [file-name (read-line)]
    (try
    (println)
      (let [decompressed-text (compress/decompress-file (slurp file-name))]
        (println decompressed-text))
      (catch java.io.FileNotFoundException _ (println "Oops: specified file does not exist.")))))



(defn compression-menu []
  (loop []
    (println)
    (println "*** Compression Menu ***")
    (println "1. Display list of files")
    (println "2. Display file contents")
    (println "3. Compress a file")
    (println "4. Uncompress a file")
    (println "5. Exit")
    (println)
    (print "Enter an option? ")
    (flush) ; Ensures the prompt is immediately displayed
    
    (let [option (read-line)]
      (println)
      (cond     
        (= option "1") (do
                         (display-file-list)
                         (recur))
        (= option "2") (do
                         (display-file-contents)
                         (recur))
        (= option "3") (do
                         (compress-file)
                         (recur))
        (= option "4") (do
                         (uncompress-file)
                         (recur))
        (= option "5") (println "Exiting...")
        :else (do
                (println "Invalid option. Please try again.")
                (recur))))))

;; Run the compression menu
(compression-menu)
