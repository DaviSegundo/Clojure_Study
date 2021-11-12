(ns estoque.examples)

(println "Bem vindo ao sistema de estoque")

"Atribuir valor"
(def total-produtos 15)
(println total-produtos)
(println "Total:" total-produtos)

"Sobrescrever número"
(def total-produtos 13)
(println "Total:" total-produtos)

"Soma"
(def total-produtos (+ total-produtos 3))
(println "Total:" total-produtos)

"Definição de vetor"
(def estoque ["Mochila", "Camiseta"])
(println "Estoque:" estoque)

"Exibição de uma posição específica"
(def posicao 0)
(println "Elemento na posicao" posicao ":" (estoque posicao))

"Contagem de elementos"
(println "N elementos:" (count estoque))

"Adicionando elementos no vetor"
(def estoque_novo (conj estoque "Cadeira"))
(println "Estoque:" estoque_novo)

"Definição de uma função customizada"
(defn imprime-msg
  []
  (println "--------------------")
  (println "Bem vindo ao estoque"))

"Chamando a função customizada"
(imprime-msg)

"Função que recebe parâmetros"
(defn aplica-desconto
  "Retorna o valor com o desconto de 10%"
  [valor-bruto]
  (* valor-bruto (- 1 0.10)))

(println (aplica-desconto 100))

(defn teste
  [valor]
  (let [d 0.10]
    (* valor (- 1 d))))

(println (teste 100))

(defn teste2
  [valor, desc]
  (let [taxa desc
        final (* valor taxa)]
    (- valor final)))

(println (teste2 90 0.2))

(defn aplica-desconto-local
  [valor-bruto]
  (let [taxa-desconto (/ 10 100)
        valor-descontado (* valor-bruto taxa-desconto)]
    (- valor-bruto valor-descontado)))

(println (aplica-desconto-local 90))

(defn aplica-desconto-condicional
  [valor-bruto]
  (if (>= valor-bruto 100)
    (let [taxa-desconto 0.10]
      (* valor-bruto (- 1 taxa-desconto)))
    valor-bruto))

(println (aplica-desconto-condicional 90))
(println (aplica-desconto-condicional 100))
(println (aplica-desconto-condicional 120))

;; "Criando símbolos locais com let"
;; (defn aplica-desconto-local
;;   "Retorna o valor com o desconto de 10%"
;;   "Variável local desconto definida dentro do escopo"
;;   [valor-bruto]
;;   (let [desconto 0.10]
;;     (* valor-bruto (- 1 desconto))))

;; (println (aplica-desconto-local 100))

;; "Incrementando função do desconto"
;; (defn valor-descontado
;;   "Retorna o valor com o desconto de 10%"
;;   "Variável local desconto definida dentro do escopo"
;;   [valor-bruto]
;;   (let [taxa-de-desconto (/ 10 100)
;;         desc1 (* valor-bruto taxa-de-desconto)]
;;     (- valor-bruto desc1)))

;; (println (valor-descontado 100))


