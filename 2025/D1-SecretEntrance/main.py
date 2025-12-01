#!/usr/bin/env python3

import sys
from typing import List, Tuple, Optional


def main(argv: List[str]) -> int:
    if len(argv) < 2:
        print("Usage: python main.py input.txt", file=sys.stderr)
        return 2
    
    password = 0
    index = 50
    with open(argv[1], "r", encoding="utf-8") as f:
        for rotation in f:
            rotation = rotation.strip()
            index = moveIndex(index, rotation[0],int(rotation[1:]))
            if index == 0:
                password+=1
    print(f"The password is {password}")            

def moveIndex(index, direction, positions):
    if direction == 'R':
        return (index + positions) % 100
    elif direction == 'L':
        return (index - positions) % 100
    else:
        raise KeyError("Error rotation")

if __name__ == "__main__":
    raise SystemExit(main(sys.argv))