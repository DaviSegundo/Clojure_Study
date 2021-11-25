(ns estoque.map-hard)

(map println ["Davi" "Camurça" "Bruno"])

(defn meu-mapa
  "Função MAP implementada na mão"
  [funcao
   sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia)))
      (do
        (println "\nTerminei.")
        (println "Obrigado!")))))

(meu-mapa println ["Davi" "Camurça" "Bruno"])


; Mapa com recursão

(defn meu-mapa
  "Função MAP implementada na mão"
  [funcao
   sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia)))
      (do
        (println "\nTerminei.")
        (println "Obrigado!")))))

;(meu-mapa println (range 10000))

; Count

(defn conta
  [total-ate-agora
   elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora))

(conta 0 ["Davi" "Camurça" "Bruno"])


; Count com polimorfismo
(defn conta

  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora
    elementos]
   (if (seq elementos)
     (recur (inc total-ate-agora) (next elementos))
     total-ate-agora)))

(conta ["Davi" "Camurça" "Bruno"])


(defn conta-for
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(conta-for ["Davi" "Camurça" "Bruno"])





