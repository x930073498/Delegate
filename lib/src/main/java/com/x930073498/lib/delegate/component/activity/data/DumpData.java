package com.x930073498.lib.delegate.component.activity.data;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class DumpData {
    public String prefix;
    public FileDescriptor fd;
    public PrintWriter writer;
    public String[] args;

    public DumpData(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        this.prefix = prefix;
        this.fd = fd;
        this.writer = writer;
        this.args = args;
    }
}
