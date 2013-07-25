package com.apache.filewatcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FileMonitorTest
{

    private static final String FILE_TO_MONITOR = "/home/syed/Downloads";
    RandomAccessFile accessFile = null;
    long lastModified;

    public class FAListener implements FileAlterationListener
    {
        File file = new File( FILE_TO_MONITOR + "/alert" );

        @Override
        public void onDirectoryChange( File arg0 )
        {
            // System.out.println( "onDirectoryChange : " + arg0 );
        }

        @Override
        public void onDirectoryCreate( File arg0 )
        {
            // System.out.println( "onDirectoryCreate : " + arg0 );

        }

        @Override
        public void onDirectoryDelete( File arg0 )
        {
            // System.out.println( "onDirectoryDelete : " + arg0 );
        }

        @Override
        public void onFileChange( File file )
        {
            System.out.println( "modify triggered" );
            // if ( file.exists() && file.lastModified() != lastModified )
            // {
            try
            {
                System.out.println( accessFile.readLine() );
                long length = accessFile.length();
                // while ( accessFile.getFilePointer() < length )
                // {
                // System.out.println( "Current Line :" + accessFile.readLine().toString() );
                // }
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
            // }
        }

        @Override
        public void onFileCreate( File arg0 )
        {
            System.out.println( "onFileCreate : " + arg0 );
            try
            {
                accessFile = new RandomAccessFile( FILE_TO_MONITOR + "/alert", "r" );
                accessFile.seek( accessFile.length() );
                lastModified = file.lastModified();

                long length = accessFile.length();
                while ( accessFile.getFilePointer() < length )
                {
                    System.out.println( "Current Line :" + accessFile.readLine().toString() );
                }
            }
            catch ( FileNotFoundException e )
            {
                e.printStackTrace();
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }
        }

        @Override
        public void onFileDelete( File arg0 )
        {
            System.out.println( "onFileDelete : " + arg0 );
            accessFile = null;
        }

        @Override
        public void onStart( FileAlterationObserver arg0 )
        {
            // System.out.println( "onStart !!!!!" );
        }

        @Override
        public void onStop( FileAlterationObserver arg0 )
        {
            // System.out.println( "onStop !!!!!" );
        }

    }

    public static void main( String[] args ) throws Exception
    {
        FileMonitorTest nt = new FileMonitorTest();
        nt.sample();
    }

    // public FileAlterationListener
    private void sample() throws Exception
    {
        System.out.println( "begin sample-> observer=" + FILE_TO_MONITOR );

        File file = new File( FILE_TO_MONITOR + "/alert" );
        accessFile = new RandomAccessFile( FILE_TO_MONITOR + "/alert", "r" );
        accessFile.seek( accessFile.length() );
        lastModified = file.lastModified();

        File directory = new File( FILE_TO_MONITOR );

        IOFileFilter files = FileFilterUtils.and(
            FileFilterUtils.fileFileFilter(),
            FileFilterUtils.nameFileFilter( "alert" ) );
        FileAlterationObserver observer = new FileAlterationObserver( directory, files );
        observer.addListener( new FAListener() );

        long interval = 1000;
        FileAlterationMonitor monitor = new FileAlterationMonitor( interval );
        monitor.addObserver( observer );
        try
        {
            monitor.start();
            // monitor.stop();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

    }
}
