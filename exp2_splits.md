# EXPERIMENT 2: Train/Test Split Ratios

Using K=6, Metric: EUCLIDEAN

## Split: 5% Train / 95% Test
**Overall Accuracy : 0,8673**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8136    | 0,4832 | 0,6063   |
| usa        | 0,8884    | 0,9681 | 0,9265   |
| france     | 0,7816    | 0,6736 | 0,7236   |
| uk         | 0,6305    | 0,3880 | 0,4804   |
| canada     | 0,7885    | 0,3647 | 0,4987   |
| japan      | 0,7465    | 0,7364 | 0,7414   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 144 | 137 | 5 | 9 | 1 | 2 | 
| **usa** | 26 | 9828 | 27 | 145 | 47 | 79 | 
| **france** | 2 | 64 | 161 | 4 | 6 | 2 | 
| **uk** | 4 | 464 | 11 | 331 | 23 | 20 | 
| **canada** | 0 | 459 | 2 | 32 | 287 | 7 | 
| **japan** | 1 | 111 | 0 | 4 | 0 | 324 | 

---

## Split: 20% Train / 80% Test
**Overall Accuracy : 0,8664**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8741    | 0,4720 | 0,6130   |
| usa        | 0,8907    | 0,9663 | 0,9270   |
| france     | 0,6794    | 0,7358 | 0,7065   |
| uk         | 0,6509    | 0,4177 | 0,5088   |
| canada     | 0,7173    | 0,3602 | 0,4796   |
| japan      | 0,7545    | 0,6829 | 0,7169   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 118 | 119 | 5 | 5 | 1 | 2 | 
| **usa** | 12 | 8261 | 39 | 113 | 66 | 58 | 
| **france** | 0 | 40 | 142 | 7 | 2 | 2 | 
| **uk** | 4 | 366 | 16 | 302 | 23 | 12 | 
| **canada** | 0 | 388 | 6 | 26 | 241 | 8 | 
| **japan** | 1 | 101 | 1 | 11 | 3 | 252 | 

---

## Split: 40% Train / 60% Test
**Overall Accuracy : 0,8684**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8879    | 0,5309 | 0,6645   |
| usa        | 0,8950    | 0,9622 | 0,9273   |
| france     | 0,7310    | 0,7211 | 0,7260   |
| uk         | 0,5604    | 0,4567 | 0,5033   |
| canada     | 0,7883    | 0,3543 | 0,4888   |
| japan      | 0,7806    | 0,6727 | 0,7227   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 103 | 79 | 2 | 8 | 0 | 2 | 
| **usa** | 10 | 6203 | 26 | 134 | 39 | 35 | 
| **france** | 0 | 31 | 106 | 8 | 1 | 1 | 
| **uk** | 3 | 245 | 8 | 232 | 7 | 13 | 
| **canada** | 0 | 287 | 3 | 28 | 175 | 1 | 
| **japan** | 0 | 86 | 0 | 4 | 0 | 185 | 

---

## Split: 60% Train / 40% Test
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

## Split: 70% Train / 30% Test
**Overall Accuracy : 0,8755**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8824    | 0,4839 | 0,6250   |
| usa        | 0,9043    | 0,9611 | 0,9318   |
| france     | 0,7368    | 0,7089 | 0,7226   |
| uk         | 0,6019    | 0,5061 | 0,5499   |
| canada     | 0,7907    | 0,4163 | 0,5455   |
| japan      | 0,7121    | 0,6963 | 0,7041   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 45 | 42 | 1 | 5 | 0 | 0 | 
| **usa** | 2 | 3110 | 13 | 61 | 26 | 24 | 
| **france** | 0 | 16 | 56 | 3 | 0 | 4 | 
| **uk** | 3 | 103 | 5 | 124 | 1 | 9 | 
| **canada** | 1 | 128 | 1 | 12 | 102 | 1 | 
| **japan** | 0 | 40 | 0 | 1 | 0 | 94 | 

---

## Split: 80% Train / 20% Test
**Overall Accuracy : 0,8769**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8710    | 0,4655 | 0,6067   |
| usa        | 0,9057    | 0,9624 | 0,9332   |
| france     | 0,7200    | 0,6792 | 0,6990   |
| uk         | 0,6220    | 0,5000 | 0,5544   |
| canada     | 0,7826    | 0,4260 | 0,5517   |
| japan      | 0,7041    | 0,7263 | 0,7150   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 27 | 26 | 1 | 4 | 0 | 0 | 
| **usa** | 1 | 2075 | 10 | 34 | 18 | 18 | 
| **france** | 0 | 11 | 36 | 2 | 0 | 4 | 
| **uk** | 2 | 68 | 2 | 79 | 2 | 5 | 
| **canada** | 1 | 86 | 1 | 7 | 72 | 2 | 
| **japan** | 0 | 25 | 0 | 1 | 0 | 69 | 

---

## Split: 95% Train / 5% Test
**Overall Accuracy : 0,8603**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8000    | 0,5000 | 0,6154   |
| usa        | 0,8996    | 0,9534 | 0,9257   |
| france     | 0,5833    | 0,6364 | 0,6087   |
| uk         | 0,6000    | 0,5000 | 0,5455   |
| canada     | 0,6500    | 0,3095 | 0,4194   |
| japan      | 0,6786    | 0,7308 | 0,7037   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 8 | 6 | 1 | 1 | 0 | 0 | 
| **usa** | 1 | 511 | 4 | 11 | 6 | 3 | 
| **france** | 0 | 2 | 7 | 0 | 0 | 2 | 
| **uk** | 1 | 15 | 0 | 21 | 1 | 4 | 
| **canada** | 0 | 27 | 0 | 2 | 13 | 0 | 
| **japan** | 0 | 7 | 0 | 0 | 0 | 19 | 

---


