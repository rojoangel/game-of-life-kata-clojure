(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(def vertical-line #{(->Cell 1 0)                           ;[0 1 0]
                     (->Cell 1 1)                           ;[0 1 0]
                     (->Cell 1 2)})                         ;[0 1 0]

(def horizontal-line #{(->Cell 0 1)                         ;[0 0 0]
                       (->Cell 1 1)                         ;[1 1 1]
                       (->Cell 2 1)})                       ;[0 0 0]

(def block #{(->Cell 1 1)                                   ;[0 0 0 0]
             (->Cell 1 2)                                   ;[0 1 1 0]
             (->Cell 2 1)                                   ;[0 1 1 0]
             (->Cell 2 2)})                                 ;[0 0 0 0]

(deftest game-of-life-tests
  (testing "blinker oscillator"
    (is (= vertical-line (first (play 1 vertical-line))))
    (is (= horizontal-line (second (play 1 vertical-line))))
    (is (= vertical-line (nth (play 2 vertical-line) 2))))
  (testing "block still life"
    (is (= block (first (play 1 block))))
    (is (= block (second (play 1 block))))))
