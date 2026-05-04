# EXPERIMENT 3: Distance Metrics

Using K=6, Split: 80/20

## Metric: EUCLIDEAN
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

## Metric: MANHATTAN
**Overall Accuracy : 0,8780**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8710    | 0,4655 | 0,6067   |
| usa        | 0,9057    | 0,9624 | 0,9332   |
| france     | 0,7308    | 0,7170 | 0,7238   |
| uk         | 0,6142    | 0,4937 | 0,5474   |
| canada     | 0,7935    | 0,4320 | 0,5594   |
| japan      | 0,7292    | 0,7368 | 0,7330   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 27 | 26 | 0 | 5 | 0 | 0 | 
| **usa** | 1 | 2075 | 10 | 34 | 18 | 18 | 
| **france** | 0 | 11 | 38 | 2 | 0 | 2 | 
| **uk** | 2 | 69 | 3 | 78 | 1 | 5 | 
| **canada** | 1 | 86 | 1 | 7 | 73 | 1 | 
| **japan** | 0 | 24 | 0 | 1 | 0 | 70 | 

---

## Metric: CHEBYSHEV
**Overall Accuracy : 0,8650**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,8438    | 0,4655 | 0,6000   |
| usa        | 0,8981    | 0,9643 | 0,9300   |
| france     | 0,6667    | 0,4528 | 0,5393   |
| uk         | 0,6230    | 0,4810 | 0,5429   |
| canada     | 0,6744    | 0,3432 | 0,4549   |
| japan      | 0,6327    | 0,6526 | 0,6425   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 27 | 25 | 1 | 5 | 0 | 0 | 
| **usa** | 1 | 2079 | 7 | 31 | 17 | 21 | 
| **france** | 0 | 13 | 24 | 2 | 7 | 7 | 
| **uk** | 2 | 72 | 2 | 76 | 1 | 5 | 
| **canada** | 1 | 99 | 1 | 7 | 58 | 3 | 
| **japan** | 1 | 27 | 1 | 1 | 3 | 62 | 

---


