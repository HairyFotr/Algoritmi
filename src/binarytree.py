from math import *

class Node:
    def __init__(self, val, l = None, r = None, parent = None):
        self.val, self.l, self.r, self.parent = val, l, r, parent
        
    def insert(self, val):
        cmp = val-self.val
        if cmp < 0:
            if self.l is None: self.l = Node(val, parent = self)
            else:              self.l.insert(val)
        elif cmp > 0:
            if self.r is None: self.r = Node(val, parent = self)
            else:              self.r.insert(val)
        else:
            return
    
    def contains(self, val):
        cmp = val-self.val
        if cmp < 0:
            if self.l is None: return False
            else:              return self.l.contains(val)
        elif cmp > 0:
            if self.r is None: return False
            else:              return self.r.contains(val)
        else:
            return True
            
    def getRoot(self): return self if self.parent is None else self.parent.getRoot()
    
    def getDepth(self, d = 0):
        return max(
            d if self.l is None else self.l.getDepth(d+1),
            d if self.r is None else self.r.getDepth(d+1)
        )
    
    def getElts(self, out = []):  
        out.append(self.val)
        if not self.l is None: self.l.getElts(out)
        if not self.r is None: self.r.getElts(out)
        return out

    def __str__(self):
        return ('(' +
            ('_' if self.l is None else str(self.l)) +
            ',' +
            str(self.val) +
            ',' +
            ('_' if self.r is None else str(self.r)) +
            ')')
    
    
    
