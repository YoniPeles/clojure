(ns learn-clojure.core
  (:gen-class))

(def my-name "yoni")
(def first-list '(1 2 3 4 5 6))
(defn my-double [num]
  (* num 2))

(def alice {:name "Alice" :age 30 :colors ["blue" "green" "red"]})
(defn rectangle-stats [width height]
  (let [perimeter (* (+ width height) 2)
        area (* width height)]
    {:perimeter perimeter :area area}))
(defn greet-person [{:keys [first-name last-name]}]
  (println (str "Good morning, " first-name " " last-name "!")))
(defn calculate
  ([number] number)
  ([first-number second-number] (+ first-number second-number))
  ([operand first-number second-number] (operand first-number second-number)))
(defn factorial [n]
  (loop [num n
         acc 1]
    (if (zero? num)
      acc
      (recur (dec num) (* acc num)))))
(defn fibs [a b]
  (lazy-seq
   (cons a
         (fibs b (+' a b)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, Clojure!")           ; ex. 1
  (println (+ 42 58))                   ; ex. 2
  (println my-name)                     ; ex. 3
  (println first-list)                  ; ex. 4
  (println (first '(1 2 3 4 5)))        ; ex. 5
  (println (my-double 7))               ; ex. 6

  (println ((alice :colors) 1))         ; ex. 7
  (println (reduce + (map my-double (filter even? (range 1 11))))) ; ex. 8
  (println (rectangle-stats 5 3))       ; ex. 9
  (greet-person {:first-name "John" :last-name "Doe" :age 25}) ; ex. 10
  (println (calculate * 3 4))           ; ex. 11
  (println (factorial 5))               ; ex. 12
  (println (-> "hello clojure world from lisp"
               (clojure.string/upper-case)
               (clojure.string/split #" ")
               (->> (take 3)
                    (clojure.string/join #"-")))) ; ex. 13
  (println (take 910 (fibs 0 1)))
  )
