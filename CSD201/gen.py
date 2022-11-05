from random import choice, randint
from string import ascii_letters

customers = [
    (
        "".join(choice(ascii_letters) for _ in range(10)),
        randint(8000000, 8999999)
    ) for _ in range(10)
]

calls = [
    (
        choice(customers)[1],
        randint(1, 10),
        randint(0, 23),
        randint(0, 59),
        randint(1, 28),
        randint(1, 12),
        randint(2000, 2022),
        choice(("NH", "LC", "X", "RX"))
    ) for _ in range(100)
]

with open("customer.dat", "w") as f:
    f.writelines(f"{c[0]}; {c[1]}\n" for c in customers)

with open("phone.dat", "w") as f:
    f.writelines(f"{c[0]} {c[1]} {c[2]}.{c[3]} {c[4]:02d}/{c[5]:02d}/{c[6]:04d} {c[7]}\n" for c in calls)
