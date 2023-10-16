







(def word-positions (atom {}))

(with-open [file (clojure.java.io/reader "frequency.txt")]
  (let [words (clojure.string/split (slurp file) #" ")]
    (doseq [word words]
      (when-not (contains? @word-positions word)
        (swap! word-positions #(assoc % word (count %)))))))



(defn is-number? [word]
  (try
    (Float/parseFloat word)
    true
    (catch NumberFormatException _ false)))


(defn reverse-word-positions [word-positions]
  (reduce (fn [result [word freq]]
            (assoc result freq word))
          {}
          word-positions))


(defn add-spaces-before-characters [text]
  (let [characters ["," "." "?" "!" ")" "]" "@" "$" "(" "["]]
    (reduce (fn [result char]
              (let [with-space (str " " char)]
                (if (or (= char "@") (= char "$"))
                  (clojure.string/replace result (str char " ") char)
                  (if (or (= char "(") (= char "["))
                    (clojure.string/replace result (str " " char " ") (str " " char))
                    (clojure.string/replace result (str " " char) char)))))
            text
            characters)))


(defn capitalized-text [encoded-text]
  (let [decompressed-text (atom [])
        compressed-words (clojure.string/split encoded-text #" ")
        capitalize-next? (atom true)]  ; Flag to indicate if the next word should be capitalized

    (doseq [compressed-word compressed-words]
      (let [capitalized-word (if @capitalize-next?
                               (clojure.string/capitalize compressed-word)
                               compressed-word)]
        (swap! decompressed-text conj capitalized-word)

        (if (re-find #"\.|\!|\?" compressed-word)
          (reset! capitalize-next? true)
          (reset! capitalize-next? false))))

    (clojure.string/join " " @decompressed-text)))

(require '[clojure.string :as string])
(require '[clojure.string :as str])

(defn remove-spaces-after-parentheses [text]
  (-> text
      
      (string/replace #"(\()\s*" "$1")
      (string/replace #"(\[)\s*" "$1")))

(defn decompress-file [encoded-text]
  (let [positions (reverse-word-positions @word-positions)
        encoded-words (clojure.string/split encoded-text #" ")
        decoded-words (map
                        (fn [compressed-word]
                          (if (and (clojure.string/starts-with? compressed-word "@")
                                   (clojure.string/ends-with? compressed-word "@")
                                   (not= compressed-word "@"))
                            (subs compressed-word 1 (- (count compressed-word) 1))
                            (if (is-number? compressed-word)
                              (get positions (Integer/parseInt compressed-word) compressed-word)
                              compressed-word)))
                        encoded-words)
        decoded-text (clojure.string/join " " decoded-words)
        text-with-spaces (add-spaces-before-characters decoded-text)
        capitalized-text (capitalized-text text-with-spaces)
        final-text (remove-spaces-after-parentheses capitalized-text)
      
        ]
    final-text))





(def encoded-text "hello 490 139 6 chut ( ( ( ( ( ( 41 ) ) ) ) ) ) 74 131 ( ( ( [ ( [ @2@ , @3@ ] ) ] ) ) ) , ( [ [ [ ( asjkdahjsd ) ] ] ] ) .")

(println (decompress-file encoded-text))


;; ;; Print the reversed word positions
;; (println reversed-word-positions)