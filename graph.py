import pandas as pd
import matplotlib.pyplot as plt

data = {
    "Array Size": [10, 50, 100, 300, 500, 700, 1000, 3000, 5000, 7000, 10000, 30000, 50000, 70000, 100000],
    "Bubble Sort": [0.012, 0.120, 0.179, 0.360, 0.446, 0.616, 0.827, 6.213, 17.493, 34.234, 68.227, 940.947, 3926.765, 8735.011, 19288.662],
    "Merge Sort": [0.035, 0.040, 0.048, 0.147, 0.245, 0.294, 0.403, 0.653, 1.712, 2.845, 5.423, 8.919, 15.176, 22.260, 35.421],
    "Counting Sort": [0.042, 0.045, 0.046, 0.057, 0.066, 0.097, 0.148, 0.238, 0.390, 0.436, 0.480, 1.490, 2.379, 4.047, 6.843]
}

df = pd.DataFrame(data)

plt.figure(figsize=(100, 6))

plt.plot(df["Array Size"], df["Bubble Sort"], label="Bubble Sort", color="blue")
plt.plot(df["Array Size"], df["Merge Sort"], label="Merge Sort", color="green")
plt.plot(df["Array Size"], df["Counting Sort"], label="Counting Sort", color="red")

plt.title("Sorting Algorithms Performance")
plt.xlabel("Array Size")
plt.ylabel("Time (milliseconds)")
plt.grid(True)
plt.legend()

plt.yscale("log")


plt.show()

# Bubble Sort
plt.figure(figsize=(100, 6))
plt.plot(df["Array Size"], df["Bubble Sort"], label="Bubble Sort", color="blue")
plt.title("Bubble Sort")
plt.xlabel("Array Size")
plt.ylabel("Time (milliseconds)")
plt.grid(True)
plt.legend()
plt.yscale("log")
plt.show()

# Merge Sort
plt.figure(figsize=(100, 6))
plt.plot(df["Array Size"], df["Merge Sort"], label="Merge Sort", color="green")
plt.title("Merge Sort")
plt.xlabel("Array Size")
plt.ylabel("Time (milliseconds)")
plt.grid(True)
plt.legend()
plt.yscale("log")
plt.show()

# Counting Sort
plt.figure(figsize=(100, 6))
plt.plot(df["Array Size"], df["Counting Sort"], label="Counting Sort", color="red")
plt.title("Counting Sort")
plt.xlabel("Array Size")
plt.ylabel("Time (milliseconds)")
plt.grid(True)
plt.legend()
plt.yscale("log")
plt.show()


fig, axs = plt.subplots(3, 1, figsize=(10, 15), gridspec_kw={'hspace': 0.4})

# Bubble Sort
axs[0].plot(df["Array Size"], df["Bubble Sort"], label="Bubble Sort", color="blue")
axs[0].set_title("Bubble Sort")
axs[0].set_xlabel("Array Size")
axs[0].set_ylabel("Time (milliseconds)")
axs[0].grid(True)
axs[0].set_yscale("log")

# Merge Sort
axs[1].plot(df["Array Size"], df["Merge Sort"], label="Merge Sort", color="green")
axs[1].set_title("Merge Sort")
axs[1].set_xlabel("Array Size")
axs[1].set_ylabel("Time (milliseconds)")
axs[1].grid(True)
axs[1].set_yscale("log")

# Counting Sort
axs[2].plot(df["Array Size"], df["Counting Sort"], label="Counting Sort", color="red")
axs[2].set_title("Counting Sort")
axs[2].set_xlabel("Array Size")
axs[2].set_ylabel("Time (milliseconds)")
axs[2].grid(True)
axs[2].set_yscale("log")

plt.show()


# Extra data

# data = {
#     "Array Size": [25, 75, 250, 750, 1250, 3000, 7500, 15000, 25000, 75000, 90000],
#     "Bubble Sort": [0.103, 0.464, 0.751, 1.829, 3.813, 25.940, 237.847, 835.508, 2628.945, 32692.387, 42584.045],
#     "Merge Sort": [0.161, 0.123, 0.362, 0.914, 3.121, 2.733, 5.759, 9.403, 15.667, 47.595, 60.426],
#     "Counting Sort": [0.090, 0.081, 0.204, 0.213, 0.298, 0.559, 0.942, 1.689, 1.712, 7.507, 6.900]
# }
