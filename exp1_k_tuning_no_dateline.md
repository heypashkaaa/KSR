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
**Overall Accuracy : 0,8719**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9286    | 0,5039 | 0,6533   |
| usa        | 0,8932    | 0,9733 | 0,9315   |
| france     | 0,7586    | 0,6168 | 0,6804   |
| uk         | 0,6143    | 0,3897 | 0,4769   |
| canada     | 0,7643    | 0,3614 | 0,4908   |
| japan      | 0,7208    | 0,6687 | 0,6937   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 65 | 53 | 2 | 8 | 1 | 0 | 
| **usa** | 3 | 4197 | 14 | 44 | 28 | 26 | 
| **france** | 0 | 27 | 66 | 7 | 2 | 5 | 
| **uk** | 2 | 179 | 4 | 129 | 6 | 11 | 
| **canada** | 0 | 189 | 1 | 21 | 120 | 1 | 
| **japan** | 0 | 54 | 0 | 1 | 0 | 111 | 

---

## K = 5 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8739**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9437    | 0,5194 | 0,6700   |
| usa        | 0,8965    | 0,9703 | 0,9320   |
| france     | 0,7634    | 0,6636 | 0,7100   |
| uk         | 0,6045    | 0,4018 | 0,4828   |
| canada     | 0,8038    | 0,3825 | 0,5184   |
| japan      | 0,6964    | 0,7048 | 0,7006   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 67 | 53 | 2 | 6 | 0 | 1 | 
| **usa** | 2 | 4184 | 15 | 51 | 28 | 32 | 
| **france** | 0 | 26 | 71 | 6 | 0 | 4 | 
| **uk** | 2 | 177 | 4 | 133 | 3 | 12 | 
| **canada** | 0 | 179 | 1 | 23 | 127 | 2 | 
| **japan** | 0 | 48 | 0 | 1 | 0 | 117 | 

---

## K = 6 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8739**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9306    | 0,5194 | 0,6667   |
| usa        | 0,8977    | 0,9692 | 0,9321   |
| france     | 0,7579    | 0,6729 | 0,7129   |
| uk         | 0,5794    | 0,4411 | 0,5009   |
| canada     | 0,8207    | 0,3584 | 0,4990   |
| japan      | 0,7342    | 0,6988 | 0,7160   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 67 | 52 | 2 | 7 | 0 | 1 | 
| **usa** | 3 | 4179 | 15 | 67 | 24 | 24 | 
| **france** | 0 | 23 | 72 | 8 | 0 | 4 | 
| **uk** | 2 | 164 | 5 | 146 | 2 | 12 | 
| **canada** | 0 | 189 | 1 | 22 | 119 | 1 | 
| **japan** | 0 | 48 | 0 | 2 | 0 | 116 | 

---

## K = 7 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8730**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9306    | 0,5194 | 0,6667   |
| usa        | 0,8974    | 0,9673 | 0,9310   |
| france     | 0,7660    | 0,6729 | 0,7164   |
| uk         | 0,5749    | 0,4290 | 0,4913   |
| canada     | 0,8026    | 0,3675 | 0,5041   |
| japan      | 0,7317    | 0,7229 | 0,7273   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 67 | 53 | 2 | 6 | 0 | 1 | 
| **usa** | 3 | 4171 | 15 | 68 | 27 | 28 | 
| **france** | 0 | 27 | 72 | 6 | 0 | 2 | 
| **uk** | 2 | 169 | 4 | 142 | 3 | 11 | 
| **canada** | 0 | 184 | 1 | 23 | 122 | 2 | 
| **japan** | 0 | 44 | 0 | 2 | 0 | 120 | 

---

## K = 10 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8719**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9130    | 0,4884 | 0,6364   |
| usa        | 0,8934    | 0,9703 | 0,9303   |
| france     | 0,7526    | 0,6822 | 0,7157   |
| uk         | 0,5946    | 0,3988 | 0,4774   |
| canada     | 0,8067    | 0,3645 | 0,5021   |
| japan      | 0,7372    | 0,6928 | 0,7143   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 63 | 58 | 2 | 5 | 0 | 1 | 
| **usa** | 4 | 4184 | 16 | 56 | 26 | 26 | 
| **france** | 0 | 26 | 73 | 6 | 0 | 2 | 
| **uk** | 2 | 181 | 5 | 132 | 3 | 8 | 
| **canada** | 0 | 185 | 1 | 21 | 121 | 4 | 
| **japan** | 0 | 49 | 0 | 2 | 0 | 115 | 

---

## K = 15 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8720**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9464    | 0,4109 | 0,5730   |
| usa        | 0,8933    | 0,9705 | 0,9303   |
| france     | 0,7476    | 0,7196 | 0,7333   |
| uk         | 0,6065    | 0,3958 | 0,4790   |
| canada     | 0,7935    | 0,3705 | 0,5051   |
| japan      | 0,7407    | 0,7229 | 0,7317   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 53 | 67 | 2 | 5 | 0 | 2 | 
| **usa** | 1 | 4185 | 17 | 53 | 28 | 28 | 
| **france** | 0 | 22 | 77 | 7 | 0 | 1 | 
| **uk** | 2 | 180 | 6 | 131 | 4 | 8 | 
| **canada** | 0 | 187 | 1 | 18 | 123 | 3 | 
| **japan** | 0 | 44 | 0 | 2 | 0 | 120 | 

---

## K = 25 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8711**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9298    | 0,4109 | 0,5699   |
| usa        | 0,8921    | 0,9719 | 0,9303   |
| france     | 0,7835    | 0,7103 | 0,7451   |
| uk         | 0,5969    | 0,3535 | 0,4440   |
| canada     | 0,7730    | 0,3795 | 0,5091   |
| japan      | 0,7289    | 0,7289 | 0,7289   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 53 | 67 | 2 | 5 | 0 | 2 | 
| **usa** | 1 | 4191 | 13 | 51 | 28 | 28 | 
| **france** | 1 | 23 | 76 | 5 | 1 | 1 | 
| **uk** | 2 | 189 | 5 | 117 | 8 | 10 | 
| **canada** | 0 | 185 | 1 | 16 | 126 | 4 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---

## K = 30 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8704**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9310    | 0,4186 | 0,5775   |
| usa        | 0,8917    | 0,9717 | 0,9300   |
| france     | 0,7835    | 0,7103 | 0,7451   |
| uk         | 0,5949    | 0,3505 | 0,4411   |
| canada     | 0,7736    | 0,3705 | 0,5010   |
| japan      | 0,7160    | 0,7289 | 0,7224   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 54 | 67 | 2 | 4 | 0 | 2 | 
| **usa** | 1 | 4190 | 13 | 52 | 28 | 28 | 
| **france** | 1 | 23 | 76 | 5 | 1 | 1 | 
| **uk** | 2 | 191 | 5 | 116 | 7 | 10 | 
| **canada** | 0 | 185 | 1 | 16 | 123 | 7 | 
| **japan** | 0 | 43 | 0 | 2 | 0 | 121 | 

---

## K = 50 (Metric: EUCLIDEAN, Split: 60/40)
**Overall Accuracy : 0,8720**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9310    | 0,4186 | 0,5775   |
| usa        | 0,8917    | 0,9717 | 0,9300   |
| france     | 0,7938    | 0,7196 | 0,7549   |
| uk         | 0,5990    | 0,3565 | 0,4470   |
| canada     | 0,7866    | 0,3886 | 0,5202   |
| japan      | 0,7469    | 0,7289 | 0,7378   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 54 | 67 | 2 | 5 | 0 | 1 | 
| **usa** | 1 | 4190 | 13 | 53 | 27 | 28 | 
| **france** | 1 | 23 | 77 | 4 | 1 | 1 | 
| **uk** | 2 | 190 | 4 | 118 | 7 | 10 | 
| **canada** | 0 | 186 | 1 | 15 | 129 | 1 | 
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


**Selected Best K for next experiments: 5**

