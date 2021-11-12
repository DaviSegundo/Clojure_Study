(ns estoque.vetores)

(def precos [30, 700, 1000])

(println (precos 0))
; (println (precos 17))
(println (get precos 0))
(println (get precos 17))
(println (get precos 17 1))

(println (conj precos 5000))
(println (update precos 0 inc))

(defn soma-10
  [valor]
  (+ valor 10))

(println (update precos 0 soma-10))

(defn aplicar-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn calcula-desconto
  [valor-bruto]
  (let [taxa-de-desconto 0.10
        desconto (* valor-bruto taxa-de-desconto)]
    (- valor-bruto desconto)))

(defn operacao
  [valor-bruto]
  (if (aplicar-desconto? valor-bruto)
    (calcula-desconto valor-bruto)
    valor-bruto))

; MAP aplica a função para cada elemento do vetor
(def n (map operacao precos))
(println n)

; RANGE é o for, onde pode ser passado o valor inicial, final e passo
(range 10)

; FILTER faz uma filtagrem de V ou F em cada elemento do vetor com base na função
(filter even? (range 10))
(filter odd? (range 10))

; Função custom para saber se é divisível por 3
(defn divisivel-3?
  [valor]
  (if (= (mod valor 3) 0)
    true))

(filter divisivel-3? (range 1 10))

; REDUCE vai aplicando para os elementos subsequentes o resultado da função dos anteriores
(reduce + precos)

(defn minha-soma
  [valor-1 valor-2]
  (+ valor-1 valor-2))

(reduce minha-soma, precos)

(map (vals estoque))
(* 0.9 (reduce + (vals estoque)))

(defn mult
  [valor]
  (* valor 0.9))

(reduce + (map mult (vals estoque)))