class Tree:
    def __init__(self, root):
        self.root = root
    
    def balance(self):
        ld = 0 if self.root.l is None else self.root.l.getDepth()
        rd = 0 if self.root.r is None else self.root.r.getDepth()
        if ld-rd > 2:
            newroot = Node(self.r.val) if self.r.r is None else Node(self.r.r.val)
            for elt in self.root.getElts(): newroot.insert(elt)
            self.root = newroot
        if rd-ld > 2:
            newroot = Node(self.l.val) if self.l.l is None else Node(self.l.l.val)
            for elt in self.root.getElts(): newroot.insert(elt)
            self.root = newroot
