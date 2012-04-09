class Node:
    def __init__(self,val,l=None,r=None,parent=None):
        self.val, self.l, self.r, self.parent = val, l, r, parent
        
    def insert(self,val):
        cmp = val-self.val
        if cmp==0: return
        elif cmp<0:
            if self.l==None: self.l=Node(val, parent=self)
            else: self.l.insert(val)
        else:
            if self.r==None: self.r=Node(val, parent=self)
            else: self.r.insert(val)
    
    def contains(self,val):
        cmp = val-self.val
        if cmp==0: return True
        elif cmp<0:
            if self.l==None: return False
            else: return self.l.contains(val)
        else:
            if self.r==None: return False
            else: return self.r.contains(val)
    
    def treeString(self):
        return ('(' +
            ('_' if self.l==None else self.l.treeString()) +
            ',' +
            str(self.val) +
            ',' +
            ('_' if self.r==None else self.r.treeString()) +
            ')')