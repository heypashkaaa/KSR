# EXPERIMENT 1: K-Value Tuning

## Dataset Statistics
- **Total texts processed (filtered):** 13441
- usa: 10685 texts
- canada: 812 texts
- japan: 466 texts
- uk: 905 texts
- france: 251 texts
- west-germany: 322 texts

## K = 0 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,0000**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,0000    | 0,0000 | 0,0000   |
| usa        | 0,0000    | 0,0000 | 0,0000   |
| france     | 0,0000    | 0,0000 | 0,0000   |
| uk         | 0,0000    | 0,0000 | 0,0000   |
| canada     | 0,0000    | 0,0000 | 0,0000   |
| japan      | 0,0000    | 0,0000 | 0,0000   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 0 | 0 | 0 | 0 | 0 | 0 | 
| **usa** | 0 | 0 | 0 | 0 | 0 | 0 | 
| **france** | 0 | 0 | 0 | 0 | 0 | 0 | 
| **uk** | 0 | 0 | 0 | 0 | 0 | 0 | 
| **canada** | 0 | 0 | 0 | 0 | 0 | 0 | 
| **japan** | 0 | 0 | 0 | 0 | 0 | 0 | 

---

## K = 1 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8501**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,6634    | 0,5194 | 0,5826   |
| usa        | 0,9032    | 0,9327 | 0,9177   |
| france     | 0,7263    | 0,6449 | 0,6832   |
| uk         | 0,5209    | 0,4894 | 0,5047   |
| canada     | 0,6091    | 0,4036 | 0,4855   |
| japan      | 0,5939    | 0,7048 | 0,6446   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 67 | 49 | 2 | 8 | 2 | 1 | 
| **usa** | 25 | 4022 | 17 | 116 | 73 | 59 | 
| **france** | 3 | 23 | 69 | 5 | 2 | 5 | 
| **uk** | 4 | 137 | 6 | 162 | 9 | 13 | 
| **canada** | 1 | 178 | 1 | 16 | 134 | 2 | 
| **japan** | 1 | 44 | 0 | 4 | 0 | 117 | 

---

## K = 4 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8717**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8500    | 0,5271 | 0,6507   |
| usa        | 0,8998    | 0,9641 | 0,9308   |
| france     | 0,7660    | 0,6729 | 0,7164   |
| uk         | 0,5894    | 0,4381 | 0,5026   |
| canada     | 0,7360    | 0,3946 | 0,5137   |
| japan      | 0,7170    | 0,6867 | 0,7015   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 68 | 49 | 2 | 8 | 1 | 1 | 
| **usa** | 10 | 4157 | 15 | 60 | 41 | 29 | 
| **france** | 0 | 23 | 72 | 7 | 1 | 4 | 
| **uk** | 2 | 165 | 4 | 145 | 4 | 11 | 
| **canada** | 0 | 176 | 1 | 24 | 131 | 0 | 
| **japan** | 0 | 50 | 0 | 2 | 0 | 114 | 

---

## K = 5 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8735**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9306    | 0,5194 | 0,6667   |
| usa        | 0,8992    | 0,9680 | 0,9323   |
| france     | 0,7660    | 0,6729 | 0,7164   |
| uk         | 0,5732    | 0,4139 | 0,4807   |
| canada     | 0,7987    | 0,3825 | 0,5173   |
| japan      | 0,7018    | 0,7229 | 0,7122   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 67 | 51 | 2 | 8 | 0 | 1 | 
| **usa** | 3 | 4174 | 15 | 60 | 28 | 32 | 
| **france** | 0 | 22 | 72 | 9 | 0 | 4 | 
| **uk** | 2 | 172 | 4 | 137 | 4 | 12 | 
| **canada** | 0 | 178 | 1 | 24 | 127 | 2 | 
| **japan** | 0 | 45 | 0 | 1 | 0 | 120 | 

---

## K = 6 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8741**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9178    | 0,5194 | 0,6634   |
| usa        | 0,9009    | 0,9657 | 0,9322   |
| france     | 0,7551    | 0,6916 | 0,7220   |
| uk         | 0,5644    | 0,4502 | 0,5008   |
| canada     | 0,8077    | 0,3795 | 0,5164   |
| japan      | 0,7317    | 0,7229 | 0,7273   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 67 | 51 | 2 | 8 | 0 | 1 | 
| **usa** | 3 | 4164 | 16 | 74 | 28 | 27 | 
| **france** | 0 | 22 | 74 | 8 | 0 | 3 | 
| **uk** | 2 | 161 | 5 | 149 | 2 | 12 | 
| **canada** | 1 | 180 | 1 | 23 | 126 | 1 | 
| **japan** | 0 | 44 | 0 | 2 | 0 | 120 | 

---

## K = 7 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8750**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9306    | 0,5194 | 0,6667   |
| usa        | 0,9006    | 0,9661 | 0,9322   |
| france     | 0,7576    | 0,7009 | 0,7282   |
| uk         | 0,5759    | 0,4471 | 0,5034   |
| canada     | 0,8141    | 0,3825 | 0,5205   |
| japan      | 0,7305    | 0,7349 | 0,7327   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 67 | 53 | 2 | 6 | 0 | 1 | 
| **usa** | 3 | 4166 | 16 | 71 | 27 | 29 | 
| **france** | 0 | 25 | 75 | 6 | 0 | 1 | 
| **uk** | 2 | 162 | 5 | 148 | 2 | 12 | 
| **canada** | 0 | 178 | 1 | 24 | 127 | 2 | 
| **japan** | 0 | 42 | 0 | 2 | 0 | 122 | 

---

## K = 10 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8726**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9130    | 0,4884 | 0,6364   |
| usa        | 0,8967    | 0,9682 | 0,9311   |
| france     | 0,7475    | 0,6916 | 0,7184   |
| uk         | 0,5837    | 0,4109 | 0,4823   |
| canada     | 0,8013    | 0,3645 | 0,5010   |
| japan      | 0,7278    | 0,7410 | 0,7343   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 63 | 58 | 2 | 5 | 0 | 1 | 
| **usa** | 4 | 4175 | 16 | 62 | 27 | 28 | 
| **france** | 0 | 25 | 74 | 6 | 0 | 2 | 
| **uk** | 2 | 173 | 6 | 136 | 3 | 11 | 
| **canada** | 0 | 184 | 1 | 22 | 121 | 4 | 
| **japan** | 0 | 41 | 0 | 2 | 0 | 123 | 

---

## K = 15 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8720**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9464    | 0,4109 | 0,5730   |
| usa        | 0,8945    | 0,9699 | 0,9307   |
| france     | 0,7476    | 0,7196 | 0,7333   |
| uk         | 0,5956    | 0,4048 | 0,4820   |
| canada     | 0,7987    | 0,3705 | 0,5062   |
| japan      | 0,7317    | 0,7229 | 0,7273   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 53 | 67 | 2 | 5 | 0 | 2 | 
| **usa** | 1 | 4182 | 17 | 56 | 28 | 28 | 
| **france** | 0 | 22 | 77 | 7 | 0 | 1 | 
| **uk** | 2 | 176 | 6 | 134 | 3 | 10 | 
| **canada** | 0 | 184 | 1 | 21 | 123 | 3 | 
| **japan** | 0 | 44 | 0 | 2 | 0 | 120 | 

---

## K = 25 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8713**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9298    | 0,4109 | 0,5699   |
| usa        | 0,8922    | 0,9717 | 0,9303   |
| france     | 0,7835    | 0,7103 | 0,7451   |
| uk         | 0,5941    | 0,3625 | 0,4503   |
| canada     | 0,7862    | 0,3765 | 0,5092   |
| japan      | 0,7289    | 0,7289 | 0,7289   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 53 | 67 | 2 | 5 | 0 | 2 | 
| **usa** | 1 | 4190 | 13 | 52 | 28 | 28 | 
| **france** | 1 | 23 | 76 | 6 | 0 | 1 | 
| **uk** | 2 | 188 | 5 | 120 | 6 | 10 | 
| **canada** | 0 | 185 | 1 | 17 | 125 | 4 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---

## K = 30 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8706**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9322    | 0,4264 | 0,5851   |
| usa        | 0,8917    | 0,9717 | 0,9300   |
| france     | 0,7835    | 0,7103 | 0,7451   |
| uk         | 0,5949    | 0,3505 | 0,4411   |
| canada     | 0,7736    | 0,3705 | 0,5010   |
| japan      | 0,7202    | 0,7289 | 0,7246   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 55 | 67 | 2 | 4 | 0 | 1 | 
| **usa** | 1 | 4190 | 13 | 52 | 28 | 28 | 
| **france** | 1 | 23 | 76 | 5 | 1 | 1 | 
| **uk** | 2 | 191 | 5 | 116 | 7 | 10 | 
| **canada** | 0 | 185 | 1 | 16 | 123 | 7 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---

## K = 50 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8722**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9310    | 0,4186 | 0,5775   |
| usa        | 0,8921    | 0,9717 | 0,9302   |
| france     | 0,7938    | 0,7196 | 0,7549   |
| uk         | 0,5980    | 0,3595 | 0,4491   |
| canada     | 0,7866    | 0,3886 | 0,5202   |
| japan      | 0,7469    | 0,7289 | 0,7378   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 54 | 67 | 2 | 5 | 0 | 1 | 
| **usa** | 1 | 4190 | 13 | 53 | 27 | 28 | 
| **france** | 1 | 23 | 77 | 4 | 1 | 1 | 
| **uk** | 2 | 189 | 4 | 119 | 7 | 10 | 
| **canada** | 0 | 185 | 1 | 16 | 129 | 1 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---

## K = 80 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8709**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9310    | 0,4186 | 0,5775   |
| usa        | 0,8911    | 0,9712 | 0,9294   |
| france     | 0,8000    | 0,7103 | 0,7525   |
| uk         | 0,5920    | 0,3595 | 0,4474   |
| canada     | 0,7862    | 0,3765 | 0,5092   |
| japan      | 0,7378    | 0,7289 | 0,7333   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 54 | 67 | 2 | 5 | 0 | 1 | 
| **usa** | 1 | 4188 | 13 | 55 | 26 | 29 | 
| **france** | 1 | 24 | 76 | 4 | 1 | 1 | 
| **uk** | 2 | 190 | 3 | 119 | 7 | 10 | 
| **canada** | 0 | 188 | 1 | 16 | 125 | 2 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---

## K = 100 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8720**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9310    | 0,4186 | 0,5775   |
| usa        | 0,8894    | 0,9754 | 0,9304   |
| france     | 0,7895    | 0,7009 | 0,7426   |
| uk         | 0,6279    | 0,3263 | 0,4294   |
| canada     | 0,7862    | 0,3765 | 0,5092   |
| japan      | 0,7378    | 0,7289 | 0,7333   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 54 | 66 | 2 | 6 | 0 | 1 | 
| **usa** | 1 | 4206 | 14 | 36 | 26 | 29 | 
| **france** | 1 | 25 | 75 | 4 | 1 | 1 | 
| **uk** | 2 | 201 | 3 | 108 | 7 | 10 | 
| **canada** | 0 | 188 | 1 | 16 | 125 | 2 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---

## K = 150 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8717**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9322    | 0,4264 | 0,5851   |
| usa        | 0,8891    | 0,9756 | 0,9303   |
| france     | 0,7895    | 0,7009 | 0,7426   |
| uk         | 0,6235    | 0,3202 | 0,4232   |
| canada     | 0,7848    | 0,3735 | 0,5061   |
| japan      | 0,7362    | 0,7229 | 0,7295   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 55 | 66 | 2 | 5 | 0 | 1 | 
| **usa** | 1 | 4207 | 13 | 36 | 26 | 29 | 
| **france** | 1 | 24 | 75 | 5 | 1 | 1 | 
| **uk** | 2 | 202 | 4 | 106 | 7 | 10 | 
| **canada** | 0 | 189 | 1 | 16 | 124 | 2 | 
| **japan** | 0 | 44 | 0 | 2 | 0 | 120 | 

---

## K = 200 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8704**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9474    | 0,4186 | 0,5806   |
| usa        | 0,8864    | 0,9756 | 0,9289   |
| france     | 0,8065    | 0,7009 | 0,7500   |
| uk         | 0,6250    | 0,3021 | 0,4073   |
| canada     | 0,7834    | 0,3705 | 0,5031   |
| japan      | 0,7378    | 0,7289 | 0,7333   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 54 | 69 | 2 | 3 | 0 | 1 | 
| **usa** | 1 | 4207 | 13 | 36 | 26 | 29 | 
| **france** | 0 | 26 | 75 | 4 | 1 | 1 | 
| **uk** | 2 | 209 | 3 | 100 | 7 | 10 | 
| **canada** | 0 | 192 | 0 | 15 | 123 | 2 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---

## K = 251 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8603**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9630    | 0,2016 | 0,3333   |
| usa        | 0,8737    | 0,9789 | 0,9233   |
| france     | 0,8491    | 0,4206 | 0,5625   |
| uk         | 0,6174    | 0,2779 | 0,3833   |
| canada     | 0,7857    | 0,3645 | 0,4979   |
| japan      | 0,7423    | 0,7289 | 0,7356   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 26 | 99 | 2 | 1 | 0 | 1 | 
| **usa** | 0 | 4221 | 3 | 35 | 25 | 28 | 
| **france** | 0 | 56 | 45 | 4 | 1 | 1 | 
| **uk** | 1 | 218 | 3 | 92 | 7 | 10 | 
| **canada** | 0 | 194 | 0 | 15 | 121 | 2 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---


**Selected Best K for next experiments: 7**

