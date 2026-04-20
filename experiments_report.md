# AUTOMATED KSR EXPERIMENTS REPORT

## 1. Performance depending on K parameter (Metric: EUCLIDEAN, Split: 60/40)
- K= 1: Global Accuracy=0,8492
- K= 2: Global Accuracy=0,8644
- K= 3: Global Accuracy=0,8698
- K= 5: Global Accuracy=0,8767
- K= 7: Global Accuracy=0,8739
- K=10: Global Accuracy=0,8726
- K=15: Global Accuracy=0,8728
- K=20: Global Accuracy=0,8713
- K=30: Global Accuracy=0,8715
- K=50: Global Accuracy=0,8717

**Selected Best K: 5**

## 2. Performance depending on Train/Test Split (K=5, Metric: EUCLIDEAN)
- Split 20/80: Global Accuracy=0,8649
- Split 40/60: Global Accuracy=0,8717
- Split 60/40: Global Accuracy=0,8767
- Split 80/20: Global Accuracy=0,8769
- Split 90/10: Global Accuracy=0,8766

## 3. Performance depending on Distance Metric (K=5, Split: 60/40)
- EUCLIDEAN : Global Accuracy=0,8767
- MANHATTAN : Global Accuracy=0,8776
- CHEBYSHEV : Global Accuracy=0,8616

## 4. Impact of Feature Subsets (K=5, Metric: EUCLIDEAN, Split: 60/40)

### Subset: All Features (12)
**Global Accuracy : 0,8767**

| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9437    | 0,5194 | 0,6700   |
| usa        | 0,8989    | 0,9712 | 0,9337   |
| france     | 0,7684    | 0,6822 | 0,7228   |
| uk         | 0,6106    | 0,4169 | 0,4955   |
| canada     | 0,8117    | 0,3765 | 0,5144   |
| japan      | 0,7151    | 0,7410 | 0,7278   |

### Subset: Numeric Only (F1-F6, F8, F12)
**Global Accuracy : 0,8587**

| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9362    | 0,3411 | 0,5000   |
| usa        | 0,8749    | 0,9745 | 0,9220   |
| france     | 0,8000    | 0,6355 | 0,7083   |
| uk         | 0,5473    | 0,2447 | 0,3382   |
| canada     | 0,7647    | 0,3524 | 0,4825   |
| japan      | 0,7447    | 0,6325 | 0,6840   |

### Subset: Textual Only (F7, F9-F11)
**Global Accuracy : 0,8722**

| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9437    | 0,5194 | 0,6700   |
| usa        | 0,8987    | 0,9650 | 0,9307   |
| france     | 0,6952    | 0,6822 | 0,6887   |
| uk         | 0,5892    | 0,4290 | 0,4965   |
| canada     | 0,7750    | 0,3735 | 0,5041   |
| japan      | 0,7235    | 0,7410 | 0,7321   |

### Subset: Country-Specific Only (F1-F6, F11)
**Global Accuracy : 0,8642**

| Class Name | Precision | Recall | F1-Score |
|------------|-----------|--------|----------|
| west-germany | 0,9310    | 0,4186 | 0,5775   |
| usa        | 0,8794    | 0,9759 | 0,9251   |
| france     | 0,7802    | 0,6636 | 0,7172   |
| uk         | 0,5736    | 0,2236 | 0,3217   |
| canada     | 0,7758    | 0,3855 | 0,5151   |
| japan      | 0,7517    | 0,6747 | 0,7111   |

