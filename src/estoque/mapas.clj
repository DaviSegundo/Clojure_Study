(ns estoque.mapas)

; Maneira de fazer dicionário
(def estoque {
              "Mochila"  10
              "Camiseta" 5
              "Sofá"     2
              "Lol"      1
              "Cama"     3
              "Tela"     8
              })

(println estoque)

; keys e valores de um dicionário, não
(keys estoque)
(vals estoque)

; Associa chaves novos ou não aos valores
(assoc estoque "Cadeira" 3)
(assoc estoque "Mochila" 8)

; Atualiza um valor
(update estoque "Mochila" (fn [v] (* v 2)))

; Desssocia um valor
(dissoc estoque "Mochila")

(map (fn [v] (* v 2)) (vals estoque))

; Maneira correta de se fazer a definição de um map
; Map aninhado
(def pedido {
             :mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             })
(println pedido)

; Associação aninhada
(assoc pedido :chaveiro {:quantidade 1 :preco 10})

; Maneiras de se chamar os elementos aninhados
(get (get pedido :mochila) :preco)
; Mais bem esclarecida abaixo
(:preco (:mochila pedido))

; maneira de dar um update dentro de um dict aninhado
(update-in pedido [:mochila :quantidade] inc)

; THREADING - encadiamento de funções de maneira direta
(-> pedido
    :mochila
    :quantidade)

(-> pedido
    :mochila
    :quantidade
    inc ,,,)

; REDUCE, MAP, FILTER em mapas

; É preciso fazer uma desestruturação do mapa para trabalhar os valores
(defn desc
  [[chave valor]]
  (println chave "$$$" valor)
  (:quantidade valor))

; Aplicando a função de maneira parecida
(map desc pedido)

; Calculo de preço por produto fazendo a multiplicação da quantidade pelo preço
(defn preco-por-produto
  [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(map preco-por-produto pedido)
(reduce + (map preco-por-produto pedido))

(defn total-pedido
  [pedido]
  (reduce + (map preco-por-produto pedido)))

(total-pedido pedido)

; Usando um exemplo com THREADING LAST
; Padrão para trabalhar com coleções
; As vírgulas indicam onde os parâmetros vão entrar, vulgo o resultado das funções anteriores

(->> pedido
     (map preco-por-produto ,,,)
     (reduce + ,,,))

(-> pedido total-pedido)

; Outra maneira de escrever a função e fazer ela funcionar
(defn calc
  [produto]
  (* (:quantidade produto) (:preco produto)))

(calc (-> pedido :mochila))

(->> pedido
     vals
     (map calc)
     (reduce +))

(def pedido-2 {
               :mochila  {:quantidade 2, :preco 80}
               :camiseta {:quantidade 3, :preco 40}
               :chaveiro {:quantidade 1}
               })

(defn checar-free
  [[chave valor]]
  (if (nil? (:preco valor))
    (println chave "É de grátis")
    (println chave "Não é grátis")))

(->> pedido-2
     (map checar-free))

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(filter gratuito? (vals pedido-2))


(filter (fn [[chave item]] (gratuito? item)) pedido-2)

(filter #(gratuito? (second %)) pedido-2)

(def pago (comp not gratuito?))

(filter #(pago (second %)) pedido-2)
