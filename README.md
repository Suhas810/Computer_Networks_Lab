# Computer Networks Lab

A collection of **Computer Networks laboratory programs written in Java**. The programs demonstrate error detection, packet traffic shaping, public-key cryptography, and shortest-path routing algorithms.

## Experiments

| No. | Program | Concept | What it demonstrates |
| --- | --- | --- | --- |
| 1 | `Crc.java` | Cyclic Redundancy Check (CRC) | Generates a CRC-based transmission and checks received data for errors. |
| 2 | `dijikstras_2.java` | Dijkstra's Algorithm | Finds a shortest path and distance between a source and destination in a weighted graph with non-negative edge weights. |
| 3 | `Bellman_3.java` | Bellman–Ford Algorithm | Calculates shortest distances from a source vertex and checks for negative-weight cycles. |
| 4 | `Leaky_bucket_04.java` | Leaky Bucket Algorithm | Simulates a fixed-capacity packet queue and controlled packet leakage. |
| 5 | `RSA_5.java` | RSA Encryption and Decryption | Demonstrates RSA key generation and a basic text encryption/decryption round trip. |

## Requirements

- Java Development Kit (JDK)
- A terminal or command prompt, or an IDE such as Visual Studio Code or IntelliJ IDEA

Check your Java installation:

```bash
java -version
javac -version
```

## Clone the Repository

```bash
git clone https://github.com/Suhas810/Computer_Networks_Lab.git
cd Computer_Networks_Lab
```

## Important: Source File Preparation

The current source files have a few naming/formatting mismatches that may prevent direct compilation:

- `Bellman_3.java` declares the public class `BellmanFord`.
- `RSA_5.java` declares the public class `RSA`.
- `Leaky_bucket_04.java` declares the public class `Leaky1`.
- `dijikstras_2.java` declares the public class `ShortestPath`.
- `Crc.java` appears to contain Markdown code fences around the Java source. Remove the opening ```` ```java ```` line and closing ```` ``` ```` line if they are present in the actual file.

In Java, a public class must be stored in a file with the same name. Rename these files to `BellmanFord.java`, `RSA.java`, `Leaky1.java`, and `ShortestPath.java`, respectively, or change the public class names to match the existing filenames. The run examples below assume the files have been renamed to match their declared public classes and the CRC code fences have been removed.

## Compile and Run

### 1. CRC — Error Detection

The program accepts a binary message, generates the data to transmit, and checks a received bit sequence.

```bash
javac -d . Crc.java
java crc.Crc
```

### 2. Dijkstra's Shortest Path

Enter the vertex count, weighted adjacency matrix, source vertex, and destination vertex. Use `0` to represent the absence of an edge, as expected by this implementation. Vertices are numbered from `0` to `V - 1`.

```bash
javac ShortestPath.java
java ShortestPath
```

### 3. Bellman–Ford Shortest Paths

Enter the vertex count, adjacency matrix, and source vertex. In this implementation, off-diagonal `0` values are treated as missing edges and replaced with `999`; use nonzero values to represent edges.

```bash
javac -d . BellmanFord.java
java crc.BellmanFord
```

### 4. Leaky Bucket

Choose an option from the menu to insert packets, simulate packet leakage, or exit. The buffer capacity is 10 packets.

```bash
javac -d . Leaky1.java
java cnlab.Leaky1
```

### 5. RSA Encryption and Decryption

Enter a text message to see the example's encryption and decryption output.

```bash
javac -d . RSA.java
java crc.RSA
```

> **Security note:** The RSA example is for learning only. It uses raw RSA operations without a secure padding scheme and should not be used to protect real data. Production applications should use established Java cryptography APIs and secure padding.

## Concepts Covered

- Error detection using CRC
- Graphs and adjacency matrices
- Shortest-path routing with Dijkstra's and Bellman–Ford algorithms
- Packet traffic shaping with the Leaky Bucket algorithm
- Introduction to RSA public-key cryptography

## Repository Structure

```text
Computer_Networks_Lab/
├── Bellman_3.java
├── Crc.java
├── Leaky_bucket_04.java
├── RSA_5.java
├── dijikstras_2.java
└── README.md
```


Made for Computer Networks lab practice and revision.
