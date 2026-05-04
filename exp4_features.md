# EXPERIMENT 4: Feature Subsets

Using K=6, Metric: MANHATTAN, Split: 80/20

## Subset: All Features (F1-F12)
**Overall Accuracy : 0,9662**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 1,0000    | 0,7759 | 0,8738   |
| usa        | 0,9731    | 0,9889 | 0,9809   |
| france     | 0,9434    | 0,9434 | 0,9434   |
| uk         | 0,9299    | 0,9241 | 0,9270   |
| canada     | 0,9236    | 0,7870 | 0,8498   |
| japan      | 0,9293    | 0,9684 | 0,9485   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 45 | 12 | 0 | 1 | 0 | 0 | 
| **usa** | 0 | 2132 | 2 | 6 | 11 | 5 | 
| **france** | 0 | 3 | 50 | 0 | 0 | 0 | 
| **uk** | 0 | 9 | 1 | 146 | 0 | 2 | 
| **canada** | 0 | 33 | 0 | 3 | 133 | 0 | 
| **japan** | 0 | 2 | 0 | 1 | 0 | 92 | 

---

## Subset: F7-F9, F12
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

## Subset: Numeric Only (F1-F6, F8, F12)
**Overall Accuracy : 0,8698**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,7692    | 0,3448 | 0,4762   |
| usa        | 0,8947    | 0,9694 | 0,9305   |
| france     | 0,7826    | 0,6792 | 0,7273   |
| uk         | 0,5957    | 0,3544 | 0,4444   |
| canada     | 0,7172    | 0,4201 | 0,5299   |
| japan      | 0,7500    | 0,6947 | 0,7213   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 20 | 30 | 0 | 5 | 3 | 0 | 
| **usa** | 3 | 2090 | 6 | 18 | 21 | 18 | 
| **france** | 0 | 16 | 36 | 0 | 0 | 1 | 
| **uk** | 3 | 88 | 4 | 56 | 4 | 3 | 
| **canada** | 0 | 84 | 0 | 14 | 71 | 0 | 
| **japan** | 0 | 28 | 0 | 1 | 0 | 66 | 

---

## Subset: Textual Only (F7, F9-F11)
**Overall Accuracy : 0,9680**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 1,0000    | 0,7759 | 0,8738   |
| usa        | 0,9740    | 0,9903 | 0,9821   |
| france     | 0,9623    | 0,9623 | 0,9623   |
| uk         | 0,9245    | 0,9304 | 0,9274   |
| canada     | 0,9366    | 0,7870 | 0,8553   |
| japan      | 0,9388    | 0,9684 | 0,9534   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 45 | 12 | 0 | 1 | 0 | 0 | 
| **usa** | 0 | 2135 | 2 | 6 | 9 | 4 | 
| **france** | 0 | 2 | 51 | 0 | 0 | 0 | 
| **uk** | 0 | 9 | 0 | 147 | 0 | 2 | 
| **canada** | 0 | 32 | 0 | 4 | 133 | 0 | 
| **japan** | 0 | 2 | 0 | 1 | 0 | 92 | 

---

## Subset: Country-Specific Only (F1-F6, F11)
**Overall Accuracy : 0,8684**

### Metrics by Class
| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9200    | 0,3966 | 0,5542   |
| usa        | 0,8849    | 0,9736 | 0,9271   |
| france     | 0,7708    | 0,6981 | 0,7327   |
| uk         | 0,6087    | 0,2658 | 0,3700   |
| canada     | 0,7471    | 0,3846 | 0,5078   |
| japan      | 0,7841    | 0,7263 | 0,7541   |

### Confusion Matrix
*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*

| Klasa | west-germany | usa | france | uk | canada | japan |
|---|---|---|---|---|---|---|
| **west-germany** | 23 | 34 | 0 | 1 | 0 | 0 | 
| **usa** | 1 | 2099 | 7 | 18 | 18 | 13 | 
| **france** | 0 | 14 | 37 | 1 | 0 | 1 | 
| **uk** | 1 | 103 | 3 | 42 | 4 | 5 | 
| **canada** | 0 | 97 | 1 | 6 | 65 | 0 | 
| **japan** | 0 | 25 | 0 | 1 | 0 | 69 | 

---


