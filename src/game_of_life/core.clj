(ns game-of-life.core)

(defn neighbors [[x y]]
  (for [dx [-1 0 1] dy (if (zero? dx) [-1 1] [-1 0 1])]
    [(+ x dx) (+ y dy)]))

(defn step [cells]
  (set (for [[loc n] (frequencies (mapcat neighbors cells))
        :when (or (= n 3) (and (= n 2) (cells loc)))]
    loc)))

(defn play [n cells]
  (take (+ n 1) (iterate step cells)))